__author__ = "kod3kid"

import os
import shutil
# import unittest


class FilesOp:
    """
    sorting and moving of files into their
    respective directories
    """

    def listFiles(dir):
        if os.path.isdir(dir):
            files =  [file for file in files if not file.endswith(".bat")] # Exclude .bat files
        return files

    def sort(files):
        """
        sorts a list of files into
        the various categories
        """
        extensions = {
            'audio': ['.mp3', '.wav', '.amr', '.ogg', '.acc'],
            'video': ['.avi', '.mkv', '.mp4', '.MP4', '.flv'],
            'image': ['.png', '.jpg', 'jpeg'],
        }
        sortedFiles  = {
            'audios': [],
            'videos': [], 
            'images': [], 
            'others': [],
            }
        
        for file in files:
            f_title, f_ext = os.path.splitext(file) # Get the extension for every file
            if f_ext in extensions['audio']:
                sortedFiles['audios'].append(file)
            elif f_ext in extensions['video']:
                sortedFiles['videos'].append(file)
            elif f_ext in extensions['image']:
                sortedFiles['images'].append(file)
            else:
                sortedFiles['others'].append(file)
        return sortedFiles

    def move(sortedFiles, dest):
        """move file into the given destination"""
        filetypes = ('images', 'audios', 'videos', 'textFiles', 'pyScripts', 'others')
        for filetype in filetypes:
            if sortedFiles[filetype] == []:
                continue
            for file in sortedFiles[filetype]:
                destination = dest + '\\{}'.format(filetype)
                # Move file to the destination if it exists else create the destinaton
                if os.path.exists(destination):
                    print('Moving {} into {}'.format(file, destination))
                    shutil.move(file, destination)
                else:
                    os.mkdir(destination)
                    print('Moving {} into {}'.format(file, destination))
                    shutil.move(file, destination)
        return 1

class TestFilesOp:

    """
    def testListFiles(self):
        contains = False
        files = ['a.x', 'b.y', 'c.bat']
        fileList = FilesOp.listFiles()
        for file in fileList:
            if file.endswith('bat'):
                contains = True
                continue
            else:
                break
        assert contains == False, "Should be false"
    """

    def testSortFilesForAudios(self):
        files = ['a.mp3', 'b.wav', 'c.ogg', 'd.txt', 'e.py', 'f.iml']
        sortedFiles = FilesOp.sort(files)
        assert sortedFiles['audios'] == ['a.mp3', 'b.wav', 'c.ogg'], "Returned list different from expected list"

    def testSortFilesForVideos(self):
        files = ['a.mp4', 'b.avi', 'c.mkv', 'd.txt', 'e.py', 'f.iml']
        sortedFiles = FilesOp.sort(files)
        assert sortedFiles['videos'] == ['a.mp4', 'b.avi', 'c.mkv'], "Returned list different from expected list"

    def testSortFilesForImages(self):
        pass

    def testMoveFiles(self):
        pass

# TestClass using Python's unittest
"""
class Testclass(unittest.TestCase):

    def testCase(var):
        contains = False
        files = ['a.x', 'b.y', 'c.bat']
        fileList = FilesOp.listFiles(files)
        for file in fileList:
            if file.endswith('bat'):
                contains = True
                continue
            else:
                break
        var.assertEqual(contains, True, "Expect True")
"""

if __name__ == '__main__':
    test = TestFilesOp()
    #test.testListFiles()
    test.testSortFilesForAudios()
    test.testSortFilesForVideos()
    print(" Tests Passed")
