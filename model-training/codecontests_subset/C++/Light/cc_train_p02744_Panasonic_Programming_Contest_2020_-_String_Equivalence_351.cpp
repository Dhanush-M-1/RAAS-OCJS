#include<bits/stdc++.h>
#define int long long
using namespace std;
int N;
void a(string S,char C){
  if(S.size()==N){
    cout<<S<<endl;
    return;
  }
  for(char c='a';c<C;c++)a(S+c,C);
  a(S+C,C+1);
}
signed main(){
  cin>>N;
  a("",'a');
}