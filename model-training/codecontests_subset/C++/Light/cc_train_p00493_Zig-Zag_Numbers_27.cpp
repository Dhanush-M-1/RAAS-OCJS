#include<bits/stdc++.h>    
using namespace std;  
  
int dp[2][3][10][500][500];  
string s;  
int M;  
  
int rec(int idx, int mod, bool free, int pre, int pre_up){  
  if(idx == s.size()) return mod == 0;  
  if(~dp[free][pre_up][pre][idx][mod]) return dp[free][pre_up][pre][idx][mod];  
  int ret = 0, end = free ? 9 : s[idx] - '0';  
  
  for(int i = 0; i <= end; i++){  
  
#define next(l)  rec( idx + 1, (mod * 10 + i) % M, free|(i != end), i, l)  
  
    if(pre_up == 1 && pre <= i) continue;  
    if(pre_up == 2 && pre >= i) continue;   
  
    if(pre_up == 0){
      if(pre && pre == i) continue;
      if(pre == 0) ret += next(0);  
      else if(pre < i) ret += next(1);  
      else if(pre > i) ret += next(2);  
    } else if(pre_up == 1){  
      ret += next(2);
    } else {
      ret += next(1);
    }
  }  
  return dp[free][pre_up][pre][idx][mod] = ret % 10000;  
}  
  
int get_value(string str){  
  s = str;  
  fill_n( ****dp, 500 * 500 * 10 * 2 * 3, -1);  
  return rec( 0, 0, false, 0, 0);  
}  
  
string sub(string s){  
  for(int i = s.size() - 1; i >= 0; i--){  
    if(s[i] == '0') s[i] = '9';  
    else{ s[i]--; break; }  
  }  
  return s;  
}  
int main(){  
  string a, b;  
  cin >> a >> b;  
  cin >> M;  
  cout << (get_value(b) - get_value(sub(a)) + 10000) % 10000 << endl;  
}  