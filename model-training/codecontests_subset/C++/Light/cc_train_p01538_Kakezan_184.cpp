#include<iostream>
#include<algorithm>
using namespace std;
 
int main(void){
  int q;
  cin>>q;
  
  for(int r = 0 ; r < q ; r ++){
    int num;
    int cnt=0;
    cin>>num;
    while(num/10 != 0){
      int n ,m ,maxn = 0;
      for(int d =  10 ; num / d != 0; d *= 10){
        maxn = max(maxn,(num/d)*(num%d));
      }
      num = maxn;
      cnt++;
    }
    cout<<cnt<<endl;
  }
}