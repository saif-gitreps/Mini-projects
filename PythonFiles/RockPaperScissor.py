from random import shuffle

#rule 1: if input == correct , then print Draw 
#rule 2: if user rock and pc scissor , point + 1
#rule 3: if user scissor and pc paper = ,point + 1
#rule 4: if user paper and pc rock = point +1 
#final if point ==5 = win 

point_count = 0 

attempt = 0

#note point count <=2 is subjective limit.

while point_count <=2:
    all_hand = ['r','p','s']
    shuffle(all_hand)
    player_guess = input("Rock?,paper?,scissor?:")
    
    if player_guess == 'r':
        if all_hand[0] == 's':
            print('your rock beats scissor')
            point_count = point_count+1
        attempt = attempt +1
      
    elif player_guess == 's':
        if all_hand[0] == 'p':
            print('your scissors beat paper')
            point_count = point_count+1
        attempt = attempt +1
        
    elif player_guess == 'p':
        if all_hand[0] == 'r':
            print('your paper beat rock')
            point_count = point_count+1
        attempt = attempt +1
        
    else:
        print("please enter s , r , p")
print(f'congrats you win in {attempt} round ') 
