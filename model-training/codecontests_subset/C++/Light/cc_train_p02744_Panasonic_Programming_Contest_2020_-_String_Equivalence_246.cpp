#include<iostream>
#include<string>
using namespace std;
int N;
void dfs(string s, char mx){
 if(s.length()==N)cout<<s<<endl;
 else {
   for(char c='a';c<=mx;c++){
     dfs(s + c, ((c == mx) ? (char)(mx + 1) : mx));
   }
 }
}
int main(void){
  cin >> N;
  dfs("", 'a');
  return 0;
}
