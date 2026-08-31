#include <bits/stdc++.h>
using namespace std;
int n;
int main() {
  scanf("%d", &n);
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) {
      int x = i * j;
      stack<int> st;
      while (x) {
        st.push(x % n);
        x /= n;
      }
      while (!st.empty()) {
        printf("%d", st.top());
        st.pop();
      }
      printf(" ");
    }
    printf("\n");
  }
}
