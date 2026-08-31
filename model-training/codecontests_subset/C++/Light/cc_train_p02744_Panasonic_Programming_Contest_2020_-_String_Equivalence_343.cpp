#include<bits/stdc++.h>

using namespace std;

int N;

void dfs(string str, char maxchar){ 
  int length = str.size();
  if (length == N){
    cout << str << endl;  
  }else{
    for(char c='a'; c<=(char)(maxchar+1); c++){
      dfs(str+c, max(c, maxchar));  
    }
  }
}

int main(){
  cin >> N;
  dfs("a", 'a');
  return 0;
}