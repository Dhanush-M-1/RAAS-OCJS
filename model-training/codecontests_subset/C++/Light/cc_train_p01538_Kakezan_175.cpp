#include <iostream>
#include <algorithm>
#include <sstream>
using namespace std;
int memo[1000001];
string tostr(int x){
  stringstream ss;
  ss << x;
  string s;
  ss >> s;
  return s;
}
int toint(string s){
  int x;
  stringstream ss;
  ss << s;
  ss >> x;
  return x;
}

int solve(int n){
  if(n<10) return 0;
  if(memo[n]) return memo[n];
  string s = tostr(n);
  int nxt = -1;
  for(int i=1;i<=s.length()-1;++i){
    string a = s.substr(0,i);
    string b = s.substr(i,s.length()-i);
    nxt = max(nxt,toint(a)*toint(b));
  }
  return memo[n]=solve(nxt)+1;
}
int main(){
  int q;
  cin >> q;
  while(q--){
    int n;
    cin >> n;
    cout << solve(n) << endl;
  }
  return 0;
}