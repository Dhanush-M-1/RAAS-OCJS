#include<iostream>
using namespace std;

int main(){
  int q;
  cin>>q;
  for(int x=0;x<q;x++){
    int n;
    cin>>n;
    int ans=0;
    while(n/10>0){
      int nn=0;
      string s=to_string(n);
      for(int i=1;i<s.size();i++){
        string a,b;
        for(int j=0;j<i;j++)a.push_back(s[j]);
        for(int j=i;j<s.size();j++)b.push_back(s[j]);
        nn=max(nn,stoi(a)*stoi(b));
        n=nn;
      }
      ans++;
    }
    cout<<ans<<endl;
  }
  return 0;
}