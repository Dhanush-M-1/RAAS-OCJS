#include<iostream>
using namespace std;
int main(){
  int num[5]={5,7,5,7,7},n,cnt=0,step,size,ie,f=0;
  string s[40];
  cin >> n;
  while(n!=0){
    cnt=0;
    step=0;
    for(int i=0;i<n;i++){
      cin >> s[i];
    }
    for(int i=0;i<n;i++){
      f=0;
      ie=0;
      for(int j=0;j<5;j++){
        size=0;
        while(num[j]>size){
        size += s[i+ie].length();
          ie++;
        }
        if(num[j]!=size){
          f=1;
          break;
        }
      }
    if(f==0){
      cout << i+1<<endl;
      break;
    }
  }
  cin >> n;
}
}

