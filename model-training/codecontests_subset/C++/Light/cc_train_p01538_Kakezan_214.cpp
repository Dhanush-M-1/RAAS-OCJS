#include <iostream>
#include <algorithm>
#include <string>
#include <cstdlib>
using namespace std;

int main() {

  int Q;
  cin >> Q;
  while(Q--) {
    string s;
    cin >> s;
    int cnt = 0;
    while(s.size() > 1) {
      int maxi = 0;
      for(int i = 1; i < s.size(); i++) {
        string left = s.substr(0, i), right = s.substr(i, s.size() - i);
        //cout << left << " " << right << endl;
        maxi = max(maxi, atoi(left.c_str()) * atoi(right.c_str()));
      }
      s = to_string(maxi);
      cnt++;
    }
    cout << cnt << endl;
  }
}