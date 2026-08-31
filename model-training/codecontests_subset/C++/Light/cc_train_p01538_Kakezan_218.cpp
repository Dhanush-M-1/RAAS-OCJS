#include <iostream>
#include <algorithm>
#include <string>
#include <cstdio>
#include <cstdlib>
using namespace std;

string toString(int n) {
  char buff[128];
  sprintf(buff, "%d", n);
  return string(buff);
}

int main() {
  int Q;
  cin >> Q;
  while(Q--) {
    string N;
    cin >> N;

    int res;
    for(res = 0; N.size() != 1; ++res) {
      int maxi = -1;
      for(int i = 1; i < (int)N.size(); ++i) {
        string a = N.substr(0,i);
        string b = N.substr(i);
        int tmp = atoi(a.c_str()) * atoi(b.c_str());
        maxi = max(maxi, tmp);
      }
      N = toString(maxi);
    }

    cout << res << endl;
  }
  return 0;
}