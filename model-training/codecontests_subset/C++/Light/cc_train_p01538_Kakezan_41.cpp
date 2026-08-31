#include<iostream>
#include<algorithm>
//#include<math.h>
using namespace std;

//int i=1;
int n;
int i=1;
int temp=0;
int ans=0;

int pow(int a,int b){
  int ans=1;
  if(b==0){
    return 1;
  }
  else{
    for(int i=0;i<b;i++){
      ans = a*ans;
    }
    return ans;
  }
}

int solve(int a){
  temp=0;
  i=1;
  while(1){
    if(a%pow(10,i)==a)break;
    else{
      temp=max(temp,(a%pow(10,i))*((a-a%pow(10,i))/pow(10,i)));
      i++;
    }
  }
  return temp;
}

int main(){
  cin >> n;
  for(int i=0;i<n;i++){
    cin >> temp;
    while(1){
      if(temp%10==temp)break;
      else{
        solve(temp);
        ans++;
      }
    }
    cout << ans << endl;
    ans=0;
  }
}

