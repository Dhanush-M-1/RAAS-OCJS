#include <iostream>
using namespace std;

enum UESH { SHITA, UE };

int n;

int main() {
  while (cin >> n) {
    if (n == 0) break;
    int res = 0;
    UESH le = SHITA, ri = SHITA, next = UE;

    for (int i = 0; i < n; ++i) {
      string str; cin >> str;

      if (str == "ld") le = SHITA;
      else if (str == "rd") ri = SHITA;
      else if (str == "lu") le = UE;
      else if (str == "ru") ri = UE;
      
      if (next == le && next == ri) {
	++res;
        if (next == UE) next = SHITA;
	else next = UE;
      }
    }

    cout << res << endl;
  }
}
