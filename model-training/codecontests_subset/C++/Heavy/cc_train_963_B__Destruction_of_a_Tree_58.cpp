#include <bits/stdc++.h>
using namespace std;
vector<int> adj[200000 + 20];
bool mitParentKante[200000 + 20];
bool ohneParentKante[200000 + 20];
void dfs(int i, int parent) {
  if (adj[i].size() == 1 && parent != -1) {
    ohneParentKante[i] = true;
    mitParentKante[i] = false;
    return;
  }
  bool geradeAnzahlOhne = true;
  for (int child : adj[i]) {
    if (child != parent) {
      dfs(child, i);
      if (!mitParentKante[child] && !ohneParentKante[child]) {
        cout << "NO" << endl;
        exit(0);
      }
      if (ohneParentKante[child]) {
        geradeAnzahlOhne = !geradeAnzahlOhne;
      }
      if (mitParentKante[child]) {
      }
    }
  }
  if (geradeAnzahlOhne) {
    ohneParentKante[i] = true;
    mitParentKante[i] = false;
  } else {
    ohneParentKante[i] = false;
    mitParentKante[i] = true;
  };
}
void deleteDFS(int i, int parent) {
  for (int child : adj[i]) {
    if (child != parent) {
      ;
      ;
      ;
      if (mitParentKante[child]) {
        deleteDFS(child, i);
      }
    }
  }
  cout << i + 1 << endl;
  for (int child : adj[i]) {
    if (child != parent) {
      if (ohneParentKante[child]) {
        deleteDFS(child, i);
      }
    }
  }
}
int32_t main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int v;
    cin >> v;
    v--;
    if (v != -1) {
      adj[v].push_back(i);
      adj[i].push_back(v);
    }
  }
  dfs(0, -1);
  if (!ohneParentKante[0]) {
    cout << "NO" << endl;
    exit(0);
  }
  cout << "YES" << endl;
  for (int i = 0; i < n; i++) {
    ;
    ;
    ;
  }
  deleteDFS(0, -1);
}
