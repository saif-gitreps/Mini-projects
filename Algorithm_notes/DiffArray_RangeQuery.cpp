/*
  lets say we have M number of queries. and each queury has
  L and R range. and an updation of any sort..
  this works in O(n^2)
*/
class Example{
private:
  for(int i=0;i<m;i++){
    for(int j=L;j<R;j++){
      a[j] += 2;
      // +2 is some sort of updation.
    }  
   }
};

class MainAlgorithm{
  /*
  given a = {2,5,7,10,15};
             0 1 2  3  4
  step 1 : make a diff array with size (orgiinal arraysize+1) N+1.
  
  step 2 : start filling the values of d[i].
           if(i==0)
              d[0] = a[0] // first element is same.
           else
              d[i] = a[i] - a[i-1];
           here, now
           d = {2 , 3 , 2, 3 , 5};
  
  step 3 : update the range [L , R] by range.
           d[L] = d[L] + x;
           d[R+1] = d[R+1] + x; 
  
        
  */
 private:
  
}

