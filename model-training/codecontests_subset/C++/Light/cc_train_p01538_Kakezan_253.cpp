#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <algorithm>

#define REP(i,n) for(int i=0;i<(int)(n);i++)

using namespace std;

int main() {
  int q;
  cin>>q;
  REP(i,q){
    string str;
    cin>>str;
    int n=0;
    while(1){
      if(str.size() == 1) break;
      int mx = 0;
      REP(j,str.size()-1){
        int fwd=stoi(str.substr(0,j+1));
        int bwd=stoi(str.substr(j+1));
        mx = max(mx, fwd*bwd);
      }
      str = to_string(mx);
      ++n;
    }
    cout<<n<<endl;
  }
  return 0;
}