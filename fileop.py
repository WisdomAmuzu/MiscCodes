import os
import shutil


class FileOp(object):
    """sorting and moving of files into separate
    directories"""

    def __init__(self):
        self.directory = ''
        self.s_files = {}

    def __file_list(self, path=''):
        self.directory = path
        if os.path.isdir(path):
            os.chdir(path)
        else:
            return

        for folderName, subfolders, filenames in os.walk(path):
            for file in filenames:
                title, ext = os.path.splitext(file)
                if ext == '' or ext in ['.bat', '.BAT']:
                    filenames.remove(file)
        self.f_list = filenames
        return filenames

    def __sort(self, lst):
        """sorts a list of files into
        the various categories"""
        path = self.directory
        file_list = self.__file_list(path)
        audio = ['.mp3', '.wav', '.amr', '.ogg', '.acc']
        video = ['.avi', '.mkv', '.mp4', '.MP4', '.flv']
        image = ['.png', '.jpg', 'jpeg']
        txt_files = ['.txt']
        py_scripts = ['.py']
        audio_list = []
        video_list = []
        image_list = []
        py_list = []
        txt_list = []
        others = []
        for file in file_list:
            f_title, f_ext = os.path.splitext(file)
            if f_ext in audio:
                audio_list.append(file)
            elif f_ext in video:
                video_list.append(file)
            elif f_ext in image:
                image_list.append(file)
            elif f_ext in txt_files:
                txt_list.append(file)
            elif f_ext in py_scripts:
                py_list.append(file)
            else:
                others.append(file)

        self.s_files['audios'] = audio_list
        self.s_files['videos'] = video_list
        self.s_files['images'] = image_list
        self.s_files['others'] = others
        return self.s_files

    def __move(self, dest=''):
        """move file into the given destination"""
        filetypes = ('images', 'audios', 'videos', 'others')
        for filetype in filetypes:
            if self.s_files[filetype] == []:
                continue
            for file in self.s_files[filetype]:
                destination = dest + '\\{}'.format(filetype)
                if os.path.exists(destination):
                    print('Moving {} into {}'.format(file, destination))
                    shutil.move(file, destination)
                else:
                    os.mkdir(destination)
                    print('Moving {} into {}'.format(file, destination))
                    shutil.copy2(file, destination)

    def file_list(self, addr):
        return self.__file_list(addr)

    def sort(self, lst):
        return self.__sort(lst)

    def move(self, dest):
        self.__move(dest=dest)
