#include<bits/stdc++.h>
using namespace std;

int divider(string str){
  int maxi=-1;
  for(int k=0;k < str.size();k++){
    string s1 = str.substr(0,k);
    string s2 = str.substr(k);
    maxi = max(maxi, atoi(s1.c_str())*atoi(s2.c_str()));
  }
  if(maxi/10) return maxi;
  else return 0;
}

string changer(int a){
  stringstream ss;
  ss << a;
  return ss.str();
}

int main()
{
  int n;
  cin >> n;
  for(int i=0;i < n;i++){
    string str;
    cin >> str;
    
    int cnt=0;
    int judge;
    string ss=str;
    
    while(judge = divider(ss)){
      ss = changer(judge);
      cnt++;
    }
    if(str.size() != 1){
      cout << cnt+1 << endl;
    }
    else cout << cnt << endl;
  }
  return 0;
}
