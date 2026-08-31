#include<iostream>
#include<climits>
#include<cassert>
#include<algorithm>
#include<cassert>
#include<map>
#include<vector>
using namespace std;
#define REP(i,b,n) for(int i=b;i<n;i++)
#define rep(i,n)   REP(i,0,n)

enum{UP=0,DOWN=1,NON=2};
const int N = 512;
const int M = 512;
const int mod = 10000;
//const int mod = 1000000;


//æ¡æ°,sum%M,æå¾ã®æ°å­,æ¬¡ã®æ°å­ãupãªã®ãdownãªã®ã,ä¸éã¨ä¸è´ãã¦ãããã©ããã
//ä½æ¡ç®ã¾ã§èª­ãã ããç¾å¨ã®%mã®å¤,åã®æå¾ã®æ¡ãup or down,ä¸éã¨ä¸è´
//500 * 500 * 10 ** 2 * 2
int dp[N][M][11][3][2];
int solve(const int n,int now,const int m,int val,int last,int st,bool match,const string &in){
  //cout <<"state " <<  now <<" "<< val <<" "<< last <<" " <<st <<" " << match << endl;
  if (now == n){
    return val == 0 && last != 10?1:0;
  }

  
  int &ret = dp[now][val][last][st][match];
  if (ret != -1)return ret;
  ret = 0;

  /*ãã®æ¡ããå§ã¾ãæ°ã*/
  if (last == 10){
    REP(i,1,10){
      bool nextMatch=false;
      if (now == 0 && i  > in[0]-'0')break;
      if (now == 0 && i == in[0]-'0')nextMatch = true;
      ret += solve(n,now+1,m,i%m,i,NON,nextMatch,in);
      ret %= mod;
    }
    ret += solve(n,now+1,m,0,10,NON,false,in);
    return ret;
  }

  REP(i,0,10){
    bool nextMatch=false;
    if (match && i > in[now]-'0')break;
    if (match && i == in[now] - '0')nextMatch = true;
    if (i == last)continue;
    if (st == UP   && i >= last)continue;  //i-1çªç®ã¨i-2çªç®ã«ã¤ãã¦i-2 < i-1 ãªã®ã§ãi-1 <= i ã¯è¨±ãããªã
    if (st == DOWN && i <= last)continue;//i-1çªç®ã¨i-2çªç®ã«ã¤ãã¦i-2 < i-1 ãªã®ã§ãi-1 <= i ã¯è¨±ãããªã
    int nextst;
    if (last < i)nextst = UP;
    if (last > i)nextst = DOWN;
    ret += solve(n,now+1,m,(i+val*10)%m,i,nextst,nextMatch,in);
    ret %= mod;
  }
  return ret;
}

int getVal(string in,int m){
  rep(i,N)rep(j,N)rep(k,11)rep(l,3)rep(n,2)dp[i][j][k][l][n] = -1;
  int ans = solve(in.size(),0,m,0,10,NON,true,in);
  return ans;
}

bool isZigzag(string &in){
  if (in.size() == 1)return true;
  if (in.size() == 2)return in[0] != in[1];
  REP(i,2,in.size()){
    if ((in[i-2] < in[i-1] && in[i-1] > in[i]) ||
	(in[i-2] > in[i-1] && in[i-1] < in[i]));
    else return false;
  }
  return true;
}

bool isModm(string &in,int m){
  int now = 0;
  rep(i,in.size()){
    now = now*10 + (in[i]-'0');
    now %= m;
  }
  return now == 0;
}

/*
  
 */
int main(){
  /*b-a + isZigzagAndModm(am)*/
  string a,b;
  int m;
  while(cin>>a>>b>>m){
    int tmp = isZigzag(a) && isModm(a,m)?1:0;
    int tb = getVal(b,m),ta = getVal(a,m);
    //cout << tb <<" " << ta <<" " << tmp << endl;
    int ans = ((tb-ta+mod)%mod+tmp)%mod;
    cout << ans << endl;
  }
}
/*
  10
  11
  12
  13
  14
  15
  16
  17
  18
  19
  20
  
  3
  6
  9
  12
  15
  18


9 3
99 27
999 177
9999 1038
99999 6315
999999 8133
ans 1234567 247
 */