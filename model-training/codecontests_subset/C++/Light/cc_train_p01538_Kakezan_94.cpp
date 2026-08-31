#include <iostream>
#include <sstream>
#include <set>
using namespace std;

int toInt(const string a){
  stringstream ss;
  ss<<a;
  int b;
  ss>>b;
  return b;
}

string toStr(const int a){
  stringstream ss;
  ss<<a;
  string b;
  ss>>b;
  return b;
}

int main(void){
  int q;cin>>q;
  for(int i=0;i<q;++i){
    int c=0;
    string s;cin>>s;
    set<string> p;
    p.insert(s);
    for(;s.size()!=1;){
      int max=0;
      for(int i=1;i<s.size();++i){
        int a=toInt(s.substr(i,s.size()-i)),b=toInt(s.substr(0,i));
        if(max<a*b) max=a*b;
      }
      ++c;
      s=toStr(max);
      if(p.find(s)!=p.end()){c=-1;break;}
      p.insert(s);
    }
    cout<<c<<endl;
  }
  return 0;
}