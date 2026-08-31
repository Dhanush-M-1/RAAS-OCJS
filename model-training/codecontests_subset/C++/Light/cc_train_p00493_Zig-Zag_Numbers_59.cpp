#include <cstdio>
#include <cstring>
#include <algorithm>
#include <iostream>
#include <string>
using namespace std;
//dp[何文字目か][直前の数字][上下][自由に選べるか][余り]
//上:0 下:1
int m;
string s;
char z[555];
int dp[501][10][3][2][500];
int solve(int n,int be,int ud,int ok,int md){
  if(n == (int)s.size()){
    //if(!md)cout << z << endl;
    return md?0:1;
  }
  if(dp[n][be][ud][ok][md] >= 0) return dp[n][be][ud][ok][md];

  int ret = 0;
  for(int i = 0; i <= ((ok)?9:(int)(s[n]-'0')); i++){
    if(ud == 0 && be <= i) continue;
    if(ud == 1 && be >= i) continue;
    if(ud == 2 && be != 0 && be == i) continue;
    int u;
    if(ud == 2){
      if(be == 0) u = 2;
      else if(be > i) u = 1;
      else u = 0;
    }else{
      u = (ud+1)%2;
    }
    //z[n] = i + '0';
    ret += solve(n+1,i,u,(ok || i != (int)(s[n]-'0'))?1:0,(md*10+i)%m);
    //z[m] = '\0';
  }
  return dp[n][be][ud][ok][md] = ret%10000;
}

int main(void){
  string c,d;
  cin >> c >> d >> m;
  for(int i = (int)c.size()-1; i >= 0; i--){
    if(c[i] == '0'){
      c[i] = '9';
    }else{
      c[i]--;
      break;
    }
  }
  s = c;
  memset(dp,-1,sizeof(dp));
  int a = solve(0,0,2,0,0);
  //cout << "A" << endl;
  s = d;
  memset(dp,-1,sizeof(dp));
  int b = solve(0,0,2,0,0);
  //cout << "B" << endl;
  //cout << a << endl;
  //cout << b << endl;
  cout << (b + 10000 - a)%10000 << endl;
}