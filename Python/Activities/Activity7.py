str = str (input ("Enter comma separated integers: "))
print("Input string: ", str) 

# convert to the list
list = str.split (",")
print ("list: ", list)

# convert each element as integers
li = []
for i in list:
	li.append(int(i))

# print list as integers
print ("list (li) : ", li)

sum = 0

# and add them in variable total
for i in range(0, len(li)):
    sum = sum + li[i]
 
# printing total value
print("Sum of all elements in given list: ", sum)