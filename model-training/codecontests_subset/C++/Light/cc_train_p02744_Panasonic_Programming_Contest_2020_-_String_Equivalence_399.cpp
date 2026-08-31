#include <iostream>
#include <string>

using namespace std;

void dfs(string s,char mx,int n){
  if(s.length() == n){
    cout << s << endl;
  }else{
    for(char c='a';c<=mx;c++){
      dfs(s+c,((c == mx) ? (char)(mx+1):mx),n);
    }
  }
}

int main(){
  int n;
  cin >> n;
  dfs("",'a',n);
  return 0;
}
