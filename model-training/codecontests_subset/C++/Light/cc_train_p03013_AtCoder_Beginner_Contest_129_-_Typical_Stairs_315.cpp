#include<bits/stdc++.h>
using namespace std;
int main(){
int N,M;
  cin>>N>>M;
  set<int>S;
  for(int i=0;i<M;i++){
  int x;
    cin>>x;
    S.insert(x);
  }int ans=0;
  int ans1=1;
  for(int i=1;i<=N;i++){
      int x=ans1;
    if(S.count(i))
    ans1=0;
    else
      ans1=(ans1+ans)%1000000007;
    ans=x;
  
  }cout<<ans1<<endl;
  
  
  
  
  
  
   return 0;
}