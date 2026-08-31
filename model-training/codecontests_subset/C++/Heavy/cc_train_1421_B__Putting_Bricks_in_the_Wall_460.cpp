#include <bits/stdc++.h>
using namespace std;
int main() {
  int testcase;
  cin >> testcase;
  for (int i = 0; i < testcase; i++) {
    int size;
    cin >> size;
    char map[size][size];
    for (int j = 0; j < size; j++) {
      for (int k = 0; k < size; k++) {
        cin >> map[j][k];
      }
    }
    char start1 = map[0][1], start2 = map[1][0], end1 = map[size - 1][size - 2],
         end2 = map[size - 2][size - 1];
    if (start1 == start2) {
      if (end1 == end2 && start1 != end1) {
        cout << "0" << endl;
        continue;
      } else if (end1 == end2) {
        cout << "2" << endl;
        cout << size << " " << size - 1 << endl;
        cout << size - 1 << " " << size << endl;
        continue;
      } else if (end1 != end2) {
        if (end1 == start1) {
          cout << "1" << endl;
          cout << size << " " << size - 1 << endl;
          continue;
        } else if (end2 == start1) {
          cout << "1" << endl;
          cout << size - 1 << " " << size << endl;
          continue;
        }
      }
    }
    if (end1 == end2) {
      if (start1 == start2 && start1 != end1) {
        cout << "0" << endl;
        continue;
      } else if (start1 == start2) {
        cout << "2" << endl;
        cout << "1 2" << endl;
        cout << "2 1" << endl;
        continue;
      } else if (start1 != start2) {
        if (end1 == start1) {
          cout << "1" << endl;
          cout << "1 2" << endl;
          continue;
        } else if (end1 == start2) {
          cout << "1" << endl;
          cout << "2 1" << endl;
          continue;
        }
      }
    }
    if (end1 != end2 && start1 != start2) {
      cout << "2" << endl;
      if (start1 == '0') {
        cout << "1 2" << endl;
      }
      if (start2 == '0') {
        cout << "2 1" << endl;
      }
      if (end1 == '1') {
        cout << size << " " << size - 1 << endl;
      }
      if (end2 == '1') {
        cout << size - 1 << " " << size << endl;
      }
    }
  }
  return 0;
}
