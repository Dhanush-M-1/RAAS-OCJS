#include <bits/stdc++.h>
using namespace std;

int N;

void dfs(string w, char ma){
  if(w.size()==N){
    cout << w << endl;
  }else{
    for(char i='a';i<=ma+1;i++){
      dfs(w+i, max(ma,i));
    }
  }
}

int main(){
  cin >> N;
  dfs("a",'a');
  return 0;
}
