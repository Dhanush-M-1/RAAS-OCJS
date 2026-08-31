#include<bits/stdc++.h>
//#include"Templates/libraries.h"
using namespace std;

int n;
void dfs(string str, char d){
  if(str.length()==n){
    cout << str << '\n';
  }else{
    for(char c='a'; c<=d;c++){
      if(c==d)dfs(str+c, (char)(d+1));
      else dfs(str+c, d);
    }
  }
}
int main(){
  cin >> n;

  dfs("",'a');
}