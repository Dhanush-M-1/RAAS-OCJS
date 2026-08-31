#include <bits/stdc++.h>
using namespace std;
long long int cases, cities, roads, nodeA, nodeB, cityA, cityB, coloredA,
    coloredB, colored;
vector<vector<long long int>> graph;
vector<long long int> colors;
bitset<(int)2e5 + 1> vis;
void coloringdfs(long long int node) {
  colors[node]++;
  vis[node] = true;
  for (auto child : graph[node])
    if (!vis[child]) coloringdfs(child);
}
void countingdfs(long long int node) {
  colored++;
  vis[node] = true;
  for (auto child : graph[node])
    if (!vis[child] && colors[child] != 2) countingdfs(child);
}
void coloringTheNodes() {
  nodeA--, nodeB--;
  colors[nodeA] = colors[nodeB] = -1;
  vis[nodeB] = true;
  vis[nodeA] = false;
  coloringdfs(nodeA);
  vis.reset();
  vis[nodeB] = false;
  vis[nodeA] = true;
  coloringdfs(nodeB);
}
void countingTheColoredNodes() {
  vis.reset();
  vis[nodeB] = true;
  countingdfs(nodeA);
  coloredA = colored - 1;
  colored = 0;
  countingdfs(nodeB);
  coloredB = colored - 1;
}
int main() {
  scanf("%lld", &cases);
  while (cases--) {
    colored = coloredA = coloredB = 0;
    graph.clear();
    colors.clear();
    vis.reset();
    scanf("%lld %lld %lld %lld", &cities, &roads, &nodeA, &nodeB);
    graph.resize(cities);
    colors.resize(cities);
    while (roads--) {
      scanf("%lld %lld", &cityA, &cityB);
      cityA--, cityB--;
      graph[cityA].push_back(cityB);
      graph[cityB].push_back(cityA);
    }
    coloringTheNodes();
    countingTheColoredNodes();
    printf("%lld\n", coloredA * coloredB);
  }
  return 0;
}
