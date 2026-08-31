#include <bits/stdc++.h>
#define r(i,n) for(int i=0;i<n;i++)
using namespace std;

int dp[501][2][4][10][501],n,m,sum;
string s,t;

int dfs(int idx,bool tight=true,int zig=3,int pre=0,int mod=0){
  if(idx==s.size())return (!mod)&&(zig<3);
  int &res=dp[idx][tight][zig][pre][mod];
  if(~res)return res;
  res=0;
  int x=s[idx]-'0';
  int r=(tight?x:9);
  for(int i=0;i<=r;i++){
    if(zig<3&&pre==i)continue;
    if(zig==0&&pre>=i)continue;
    if(zig==1&&pre<=i)continue;
    res+=dfs(idx+1,tight&&i==r,zig<2?zig^1:zig==2?pre<i:i?2:3,i,(mod*10+i)%m);
    res%=10000;
  }
  return res;
}


int main(){
  memset(dp,-1,sizeof(dp));
  cin>>s>>t>>m;
  int A=dfs(0);
  memset(dp,-1,sizeof(dp));
  swap(s,t);
  int B=dfs(0);
  r(i,t.size())sum+=(sum*10+(t[i]-'0'))%m;
  cout<<(B-A+10000+!sum)%10000<<endl;
}
