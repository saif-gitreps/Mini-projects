/*
Here's a high-level description of the algorithm:

Starting from the last element of the array, select a random element from the entire array (including the element itself).
Swap the selected element with the current element.
Move to the previous element in the array and repeat steps 1 and 2.
Continue this process until the first element of the array is reached. */

#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

void Fisher_Yates(vector<int>& nums){
    int n = nums.size();
    for(int i = n-1; i>=0; i--){
        int j = rand() % i+1;
        swap(nums[i],nums[j]);
    }
}

// ok so why rand() % i+1 ?
/*
    here rand will generate a random number from one to rand_max 
    and if we use rand()% i, then the value will be between i-1 and 0 , and we add+1 to keep inbound.
    ok so after testing i see that any random value mod 0-num.size() will result in random numbers from 0-num.size().
*/


int main(){
    vector<int> nums = {1,2,3,4,5};
    Fisher_Yates(nums);
    //print nums now - > 
}
