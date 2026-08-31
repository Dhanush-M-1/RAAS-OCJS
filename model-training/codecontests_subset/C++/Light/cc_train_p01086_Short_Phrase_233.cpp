#include <iostream>
using namespace std;

int main()
{
  while(1){
    int n;
    cin >> n;
    if(n == 0) break;
    string w[n];
    bool k[500] = {};
    k[0] = true;
    string s = "";
    int m[n+1];
    m[0] = 0;
    for(int i = 0; i < n; i++){
      cin >> w[i];
      s += w[i];
      k[s.size()] = true;
      m[i+1] = s.size();
    }
    for(int i = 0; i < n; i++){
      if(s.size()-m[i]+1 < 31) continue;
      if(k[m[i]] && k[m[i]+5] && k[m[i]+12] && k[m[i]+17] && k[m[i]+24] && k[m[i]+31]){
        cout << i+1 << endl;
        break;
      }
    }
  }
}