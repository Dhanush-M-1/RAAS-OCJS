#include<iostream>
#include<cstdio>
#include<algorithm>
#include<cstring>
#include<string>
#include<vector>
#include<queue>
using namespace std;
#define MOD (10000)
string A,B;
int a[511],b[511];
int M,N;
int dp[501][501][10][2][3];//桁、割ったあまり、前回の値、減少or増加、aを使ったかbを使ったか
int lth(int num,int n){
  return (num*10+n)%M;
}
//桁,割ったあまり,前回の値,1:増加or2:減少,1bit:aを使ったか2bit:bを使ったか,0以外が出たかどうか
int solve(int no,int m,int zg,int zgf,int fl,bool uz){
  //  printf("%d %d %d %d %d\n",no,m,zg,zgf,fl);
  if(no==N){
    if(m==0 && uz)
      //printf("%d %d %d %d %d\n",no,m,zg,zgf,fl);
      return 1;
      //return 1;
    else 
      return 0;
    //return 0;
  }
  if(zgf>=0) if(dp[no][m][zg][zgf][fl]!=-1) return dp[no][m][zg][zgf][fl];
  int ret = 0;
  for(int i=0;i<=9;i++){
    /*    if(!uz){
      if( i < a[no] ) continue;
      ret += solve(no+1,lth(m,i),i,0,fl,(uz || i!=0));
      ret %= MOD;
      } else{*/
      if(zgf==0 && zg<i) continue;
      if(zgf==1 && zg>i) continue;
      if(zg==i  && uz) continue;
      if( i < a[no] && (fl&1) ) continue;
      if( i > b[no] && (fl&2) ) continue;
      int fl2 = fl;
      if( i != a[no] ) fl2=fl2&~1;
      if( i != b[no] ) fl2=fl2&~2;
      int zgf2;
      if(zg<i) zgf2=0;
      else zgf2=1;
      if(!uz) zgf2=-1;
      ret += solve(no+1,lth(m,i),i,zgf2,fl2,uz || i!=0);
      ret%=MOD;
    
  }
  if(zgf>=0)
    return dp[no][m][zg][zgf][fl]=ret;
  return ret;
    //return ret;
}
int solve(){
  int ret=0;
  for(int i=0; i<=9; i++){
    int fl=3;
    if( i < a[0] ) continue;
    if( i > b[0] ) continue;
    if( i != a[0]) fl=fl&~1;
    if( i != b[0] ) fl=fl&~2;
    ret += solve(1,i%M,i,-1,fl,i!=0);
    ret%=MOD;
  }
  return ret;
}
int main(){
  memset(dp,-1,sizeof(dp));
  cin >> A >> B >> M;
  N = B.size();
  for(int i=0;i<N;i++){
    b[i]=B[i]-'0';
    if(N-(int)A.size()<=i) a[i]=A[i-(N-(int)A.size())]-'0';
  }
  /*  for(int i=0;i<N;i++) cout << a[i];
  puts("");
  for(int i=0;i<N;i++) cout << b[i];
  puts("");*/
  cout << solve() << "\n";
}