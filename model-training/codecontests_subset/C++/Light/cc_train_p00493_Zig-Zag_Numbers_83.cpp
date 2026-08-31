#include<iostream>
#include<string>
#define M 10000
using namespace std;

int dp[2][2][3][10][550]; //dp[digit][bound][dec or else or inc][prv num][mod]

int zig(string s,int m){
  int n = s.size(),up,mod,ub;

  for(int j=0;j<3;j++)
    for(int k=0;k<10;k++)
      for(int l=0;l<m;l++)
	dp[0][0][j][k][l] = dp[0][1][j][k][l] = 0;
  dp[0][1][1][0][0] = 1;

  for(int i=0;i<n;i++){
    int odd = i&1;
    for(int j=0;j<3;j++)
      for(int k=0;k<10;k++)
	for(int l=0;l<m;l++)
	  dp[1-odd][0][j][k][l] = dp[1-odd][1][j][k][l] = 0;

    for(int j=0;j<2;j++){
      if(j==1)up = s[i]-'0';
      else up = 9;
      for(int k=0;k<3;k++){
	for(int l=0;l<10;l++){
	  for(int x=0;x<=up;x++){
	    if(k==0 && x<=l)continue;
	    if(k==2 && l<=x)continue;
	    for(int y=0;y<m;y++){
	      mod = (y*10 + x) % m;
	      if(j==1 && x==up)ub = 1;
	      else ub = 0;

	      if(k==1 && l==0){
		dp[1-odd][ub][1][x][mod] += dp[odd][j][k][l][y];
		dp[1-odd][ub][1][x][mod] %= M;
	      }else if(x<l){
		dp[1-odd][ub][0][x][mod] += dp[odd][j][k][l][y];
		dp[1-odd][ub][0][x][mod] %= M;
	      }else if(x>l){
		dp[1-odd][ub][2][x][mod] += dp[odd][j][k][l][y];
		dp[1-odd][ub][2][x][mod] %= M;
	      }
	    }
	  }
	}
      }
    }
  }
 
  int ans = 0;
  for(int i=0;i<2;i++)
    for(int j=0;j<3;j++)
      for(int k=0;k<10;k++){
	ans += dp[n&1][i][j][k][0];
	ans %= M;
      }
  return ans;
}

string dec(string a){
  int n = a.size() - 1;
  while(a[n]=='0'){
    a[n--] = '9';
  }
  a[n]--;
  if(a[n] == '0')a = a.substr(1,n-1);
  return a;
}

int main(){
  string a,b;
  int m;
  cin >> a >> b >> m;
  cout << (zig(b,m) - zig(dec(a),m) + M) % M << endl;
}