#include<iostream>
#include<string>
#include<algorithm>
using namespace std;
#define MOD 10000
 
string s;
short dp[2][3][10][500][501]; //[free][増減][prev][余り][index]
int m;
 
int solve( bool fr, int updw, int pre, int mod, int index){
  if( index == s.size() ) return !mod;
  if( dp[fr][updw][pre][mod][index] != -1 ) return dp[fr][updw][pre][mod][index];
  int ret = 0, end = fr ? 9 : s[index];
  for(int i = 0, u ; i <= end ; i++ ){
    switch(updw){
    case 0: //さいしょ
      if( pre && pre == i ) continue;
      else if( pre == 0 ) u = 0;
      else if( pre > i ) u = 1;
      else u = 2;
      break;
    case 1: //次あっぷ
      if( pre >= i ) continue;
      else u = 2;
      break;
    case 2: //次だうん
      if( pre <= i ) continue;
      else u = 1;
      break;
    }
    ret += solve( fr|(i!=s[index]), u, i, (mod*10+i)%m, index+1);
  }
  return dp[fr][updw][pre][mod][index] = ret % MOD;
}
 
void java(){
  for(int i = s.size() - 1 ; i >= 0 ; i-- ){
    if(s[i] == 0) s[i] = 9;
    else{
      s[i]--;
      break;
    }
  }
}

void init(){
    for(int j = 0 ; j < 3 ; j++ )
      for(int k = 0 ; k < 10 ; k++ )
	for(int l = 0 ; l < m ; l++ )
	  for(int q = 0 ; q <= s.size() ; q++ )
	    dp[0][j][k][l][q] = dp[1][j][k][l][q] = -1;
}

int main(){
  string s1;
  cin >> s >> s1 >> m;
  for(int i = 0 ; i < s.size() ; i++ ) s[i] -= '0';
  java();
  init();
  int an = solve( 0, 0, 0, 0, 0);
  s = s1;
  for(int i = 0 ; i < s.size() ; i++ ) s[i] -= '0';
  init();
  int bn = solve( 0, 0, 0, 0, 0);
  cout << ( bn - an + MOD ) % MOD << endl;
}