#include <iostream>
#include <string>
using namespace std;

// 方針：-1が出力されることはない。
// 普通に数えて終わり。

int step (int L) {
  string S = to_string(L);
  int res = 0;
  for (auto i=1; i<S.size(); i++) {
    int I1 = stoi(S.substr(0, i));
    int I2 = stoi(S.substr(i, S.size()-i));
    int temp = I1 * I2;
    // cerr << "I1 = " << I1 << ", I2 = " << I2 << ", temp = " << temp << endl;
    if (res < temp) res = temp;
  }
  return res;
}

int count_step (int L) {
  int res = 0;
  for ( ; L>=10 ; res++) {
    // cerr << "res = " << res << endl;
    L = step(L);
  }
  return res;
}

int main() {
  int Q;
  cin >> Q;
  for (auto i=0; i<Q; i++) {
    int N;
    cin >> N;
    cout << count_step(N) << endl;
  }
}