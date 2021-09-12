import random
# the player inputs a number and the computer tries to guess
class Trade_game(object):
    """An object for the trade_game"""
    def __init__(self):
	print ('\t Title : Guess a number game.')
	print ('\t Credit : Proffessor Amuzu of Wise Technologies Co.')
	self.rules()
    def rules(self) :
    	print("""
        You are supposed to pick a number between 1 and 10.
        After that, I guess the number and tell you how many
        times I tried.
        I then also pick a number and you try to guess it.
        If you are not able to guess within the number of times 
        I guessed, I win. But if you are able, then you win
        """)
    def play(self):
        number = int(input("enter a number between 1 and 10 : "))
        guess = random.randint(1,10)
    	tries = 1
    	while guess != number:
	    guess = random.randint(1,10)
	    tries+=1
	print ("\n Hoa, you see I made it with just",tries,"tries.")

    	number = random.randint(1,10)
    	guess = int(input(" \nEnter the number : "))
    	tries_1 = 1
    	while guess != number :
            guess = int(input("\n Please enter again : "))
	    tries_1 +=1
	    if tries_1 <=tries and guess ==number:
		print "\n You win"
	    elif tries_1 == tries and guess != number :
		print ("\n Game Over")
	    break		
		
        print ("\n Thanks for playing")
    def close(self):
        cls = input('Press the enter key to exit : ')
        if cls == 'enter' :
            self.quit()
trade = Trade_game()
trade.play()
trade.close()