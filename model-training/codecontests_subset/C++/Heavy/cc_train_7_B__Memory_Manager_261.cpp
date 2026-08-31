#include <bits/stdc++.h>
using namespace std;
int Q, N;
long long mem[100];
long long ids = 1;
long long INIT = 1e12;
void defrag() {
  int idx = 0;
  for (int i = 0; i < N; i++) {
    if (mem[i] != INIT) {
      mem[idx] = mem[i];
      idx++;
    }
  }
  for (; idx < N; idx++) {
    mem[idx] = INIT;
  }
}
void alloc() {
  int val;
  cin >> val;
  int start = 0;
  bool success = false;
  for (int i = 0; i < N; i++) {
    if (mem[i] != INIT) {
      start = i + 1;
    } else if (i - start + 1 >= val) {
      for (int j = 0; j < val; j++) {
        mem[start + j] = ids;
      }
      success = true;
      break;
    }
  }
  if (success) {
    cout << ids << endl;
    ids++;
  } else {
    cout << "NULL" << endl;
  }
}
void erase() {
  int id;
  cin >> id;
  bool found = false;
  for (int i = 0; i < N; i++) {
    if (mem[i] == id) {
      mem[i] = INIT;
      found = true;
    }
  }
  if (!found) {
    cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  cin >> Q >> N;
  for (int i = 0; i < N; i++) {
    mem[i] = INIT;
  }
  string op;
  for (int i = 0; i < Q; i++) {
    cin >> op;
    if (op == "defragment") {
      defrag();
    } else if (op == "alloc") {
      alloc();
    } else {
      erase();
    }
  }
  return 0;
}
