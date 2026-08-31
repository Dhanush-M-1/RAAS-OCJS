#include <bits/stdc++.h>
using namespace std;
int numberOfTests = 1;
bool result;
int m;
int n;
vector<bool> lights;
void resetData() {
  result = 0;
  lights.clear();
}
void readInput() {
  cin >> n >> m;
  lights.resize(m + 2, false);
  for (int i = 0; i < n; ++i) {
    int k;
    cin >> k;
    for (int j = 0; j < k; ++j) {
      int temp;
      cin >> temp;
      lights[temp] = true;
    }
  }
}
void computeResult() {
  result = true;
  for (int i = 1; i <= m; ++i) {
    if (lights[i] == false) {
      result = false;
      break;
    }
  }
}
void printResult() { cout << (result ? "YES" : "NO") << endl; }
int main(int argc, char* argv[]) {
  ios_base::sync_with_stdio(false);
  if (argc > 1 && strcmp(argv[1], "LOCAL") == 0) {
    freopen("CppInput.txt", "r", stdin);
    cin >> numberOfTests;
  }
  for (int i = 0; i < numberOfTests; ++i) {
    resetData();
    readInput();
    computeResult();
    printResult();
  }
  return EXIT_SUCCESS;
}
