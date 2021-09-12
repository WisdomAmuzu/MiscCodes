# My simple calculator application

import tkinter
from tkinter import ttk

class Calculator(tkinter.Frame):
    '''Calculator Application'''
    value = ' '
    tmpval = ' '
    def __init__(self, master = None):
        tkinter.Frame.__init__(self, master)
        self.main()
        self.grid(sticky = self.sticks)
        
    def initUi(self):
        self.btnWidth = 3
        self.sticks = 'nw,ne,sw,se'
            
        self.lbl = ttk.Label(self, width = 6, text = Calculator.value)
        btn1 = ttk.Button(self,text = '1', width = self.btnWidth,
                      command = self.showone)
        btn2 = ttk.Button(self,text = '2', width = self.btnWidth,
                      command = self.showtwo)
        btn3 = ttk.Button(self,text = '3', width = self.btnWidth,
                      command = self.showthree)
        btn4 = ttk.Button(self,text = '4', width = self.btnWidth,
                      command = self.showfour)
        btn5 = ttk.Button(self,text = '5', width = self.btnWidth,
                      command = self.showfive)
        btn6 = ttk.Button(self,text = '6', width = self.btnWidth,
                      command = self.showsix)
        btn7 = ttk.Button(self,text = '7', width = self.btnWidth,
                      command = self.showseven)
        btn8 = ttk.Button(self,text = '8', width = self.btnWidth,
                      command = self.showeight)
        btn9 = ttk.Button(self,text = '9', width = self.btnWidth,
                      command = self.shownine)
        btn0 = ttk.Button(self,text = '0', width = self.btnWidth,
                      command = self.showzero)
        btnplus = ttk.Button(self,text = '+', width = self.btnWidth,
                      command = self.showplus)
        btnminus = ttk.Button(self,text = '-', width = self.btnWidth,
                      command = self.showminus)
        btntimes = ttk.Button(self,text = 'x', width = self.btnWidth,
                      command = self.showtimes)
        btndiv = ttk.Button(self,text = '/', width = self.btnWidth,
                      command = self.showdiv)
        btnexp = ttk.Button(self,text = '^', width = self.btnWidth,
                      command = self.showexp)
        btnclr = ttk.Button(self,text = 'clr', width = self.btnWidth,
                      command = self.showclr)
        btndel = ttk.Button(self,text = 'del', width = self.btnWidth,
                      command = self.showdel)
        btncalc = ttk.Button(self, text = '=', width = self.btnWidth,
                      command = self.calc)
        self.lbl.grid(row = 0, sticky = self.sticks)
        btn1.grid(row = 1,column = 0, sticky = self.sticks)
        btn2.grid(row = 1,column = 1, sticky = self.sticks)
        btn3.grid(row = 1,column = 2, sticky = self.sticks)
        btn4.grid(row = 2,column = 0, sticky = self.sticks)
        btn5.grid(row = 2,column = 1, sticky = self.sticks)
        btn6.grid(row = 2,column = 2, sticky = self.sticks)
        btn7.grid(row = 3,column = 0, sticky = self.sticks)
        btn8.grid(row = 3,column = 1, sticky = self.sticks)
        btn9.grid(row = 3,column = 2, sticky = self.sticks)
        btn0.grid(row = 4,column = 0, sticky = self.sticks)
        btnplus.grid(row = 4,column = 1, sticky = self.sticks)
        btnminus.grid(row = 4,column = 2, sticky = self.sticks)
        btntimes.grid(row = 5,column = 0, sticky = self.sticks)
        btndiv.grid(row = 5,column = 1, sticky = self.sticks)
        btnexp.grid(row = 5,column = 2, sticky = self.sticks)
        btnclr.grid(row = 6,column = 0, sticky = self.sticks)
        btndel.grid(row = 6,column = 1, sticky = self.sticks)
        btncalc.grid(row = 6,column = 2, sticky = self.sticks)
        
    def showone(self):
        Calculator.value += '1'
        Calculator.tmpval = '1'
        self.lbl.config(text = Calculator.value)
    def showtwo(self):
        Calculator.value += '2'
        Calculator.tmpval = '2'
    
    def showthree(self):
        Calculator.value += '3'
        Calculator.tmpval = '3'
    
    def showfour(self):
        Calculator.value += '4'
        Calculator.tmpval = '4'
        self.lbl.config(text = Calculator.value)
    
    def showfive(self):
        Calculator.value += '5'
        Calculator.tmpval = '5'
        self.lbl.config(text = Calculator.value)
    
    def showsix(self):
        Calculator.value += '6'
        Calculator.tmpval = '6'
        self.lbl.config(text = Calculator.value)
    
    def showseven(self):
        Calculator.value += '7'
        Calculator.tmpval = '7'
        self.lbl.config(text = Calculator.value)
    
    def showeight(self):
        Calculator.value += '8'
        Calculator.tmpval = '8'
        self.lbl.config(text = Calculator.value)
    
    def shownine(self):
        Calculator.value += '9'
        Calculator.tmpval = '9'
        self.lbl.config(text = Calculator.value)
    
    def showzero(self):
        Calculator.value += '0'
        Calculator.tmpval = '0'
        self.lbl.config(text = Calculator.value)
    
    def showplus(self):
        Calculator.value += '+'
        Calculator.tmpval = '+'
        self.lbl.config(text = Calculator.value)
    
    def showminus(self):
        Calculator.value += '-'
        Calculator.tmpval = '-'
        self.lbl.config(text = Calculator.value)
    
    def showtimes(self):
        Calculator.value += 'x'
        Calculator.tmpval = 'x'
        self.lbl.config(text = Calculator.value)
    
    def showdiv(self):
        Calculator.value += '/'
        Calculator.tmpval = '/'
        self.lbl.config(text = Calculator.value)
    
    def showexp(self):
        Calculator.value += '^'
        Calculator.tmpval = '^'
        self.lbl.config(text = Calculator.value)
        
    def showclr(self):
        Calculator.value = ' '
        self.lbl.config(text = Calculator.value)
    
    def showdel(self):
        Calculator.value -= Calculator.tmpval
        self.lbl.config(text = Calculator.value)
    
    def calc(self):
        try :
            self.lbl.config(text = eval(Calculator.value))
        except :
            self.lbl.config(text = 'Error')
    
    def main(self):
        self.initUi()
        
root = tkinter.Tk()

app = Calculator(root)

root.mainloop()