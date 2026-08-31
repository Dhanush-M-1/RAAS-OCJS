#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;
int main(int argc, char *argv[])
{
  for(;;) {
    int n;
    cin >> n;
    if(n == 0) break;
    vector<int> ls;
    for(int i = 0; i < n; i++) {
      string s;
      cin >> s;
      ls.push_back(s.length());
    }
    for(int i = 0; i < n; i++) {
      int j = i, k = 0;
      int tls[] = {5,7,5,7,7};
      for(;;) {
        if(ls[j] <= tls[k]) {
          tls[k]-=ls[j];
          j++;
        } else {
          break;
        }
        if(tls[k] == 0) k++;
        if(k == 5) {
          cout << (i+1) << endl;
          i = n;
          break;
        }
      }
    }
  }
  return 0;
}