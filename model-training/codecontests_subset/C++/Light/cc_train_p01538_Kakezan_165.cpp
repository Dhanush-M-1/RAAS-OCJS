#include<bits/stdc++.h>
using namespace std;

int Q;

int main(){
  cin >> Q;
  for(int i=0;i<Q;i++){
    set<int> F;
    string n; cin >> n;
    int cnt = 0;
    while( n.size() > 1 ){
      int mn = -1;      
      for(int i=1;i<n.size();i++){
        string a = n.substr(i), b = n.substr(0,i);
        int x = stoi(a);
        int y = stoi(b);
        mn = max( mn, x*y );
      }
      if( F.count( mn ) == 0 ) {
        cnt++;
        F.insert( mn );
        n = to_string( mn );
      } else {
        cnt = -1;
        break;
      }
    }
    cout << cnt << endl;
  }
}