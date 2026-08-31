#include<iostream>
#include<string>
#include<sstream>
#include<algorithm>
#include<cstdlib>
#include<cstring>
using namespace std;
string StringChanger(int);
string StringChanger(int n){
  stringstream ss;
  ss << n;
  return ss.str();
}
int main(){
  int q,maxy;
  string str;
  cin >> q;
  for(int i=0;i<q;i++){
    cin >> str;
    int cnt = 0;
    while(str.size()!=1){
      int maxy = 0;
      for(int j=0,l=str.size();j<l;j++){
        string sub1 = str.substr(0,j);
        string sub2 = str.substr(j);
        maxy = max(maxy,atoi(sub1.c_str())*atoi(sub2.c_str()));
      }
      str = StringChanger(maxy);
      cnt++;
    }
    cout << cnt << endl;
  }
}