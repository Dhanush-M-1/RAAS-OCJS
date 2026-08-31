#include <bits/stdc++.h>
int main() {
  int n, k, i;
  int students[100];
  int Awruk = 0, Elodreip = 0;
  scanf("%d", &n);
  for (i = 0; i < n; i++) {
    scanf("%d", &students[i]);
  }
  int biggest_vote = students[0];
  for (i = 0; i < n; i++) {
    if (students[i] > biggest_vote) {
      biggest_vote = students[i];
    }
  }
  for (k = biggest_vote; k < 202; k++) {
    for (i = 0; i < n; i++) {
      Elodreip = Elodreip + students[i];
      Awruk = Awruk + (k - students[i]);
    }
    if (Awruk > Elodreip) break;
    Awruk = 0, Elodreip = 0;
  }
  printf("%d\n", k);
}
