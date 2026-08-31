#include <bits/stdc++.h>
enum class LampConstraint { Distinct, Same };
enum class LampSetState { On, Off, PhantomA, PhantomB };
bool isLampSetStateKnown(LampSetState st) {
  return st == LampSetState::On || st == LampSetState::Off;
}
typedef struct Edge {
  int nodeId;
  LampConstraint cons;
  Edge(int nodeId_, LampConstraint cons_) : nodeId(nodeId_), cons(cons_) {}
} Edge;
bool compareEdges(const Edge &a, const Edge &b) {
  if (a.nodeId < b.nodeId) return true;
  if (a.nodeId > b.nodeId) return true;
  return a.cons < b.cons;
}
typedef struct LampSetInfo {
  LampSetState state;
  int ownerId;
  int componentSize;
  int onColorSize;
  int offColorSize;
  explicit LampSetInfo(int id)
      : state(LampSetState::PhantomA),
        ownerId(id),
        componentSize(1),
        onColorSize(1),
        offColorSize(0){};
} LampSetInfo;
typedef std::set<Edge, decltype(compareEdges) *> Edges;
int componentOnBestSize(std::vector<LampSetInfo> &nodes, int nodeId) {
  LampSetInfo &s = nodes[nodeId];
  int ownerId = s.ownerId;
  if (s.state == LampSetState::On || s.state == LampSetState::Off) {
    return nodes[ownerId].onColorSize;
  } else {
    return std::min(nodes[ownerId].onColorSize, nodes[ownerId].offColorSize);
  }
}
LampSetState deducedState(const LampConstraint &cons, LampSetState st) {
  switch (cons) {
    case LampConstraint::Same:
      return st;
    case LampConstraint::Distinct:
      switch (st) {
        case LampSetState::On:
          return LampSetState::Off;
        case LampSetState::Off:
          return LampSetState::On;
        case LampSetState::PhantomA:
          return LampSetState::PhantomB;
        case LampSetState::PhantomB:
          return LampSetState::PhantomA;
      }
  }
}
void propagateLampState(const std::vector<Edges> &graph,
                        std::vector<LampSetInfo> &nodes, int startNodeId,
                        LampSetState learnedState) {
  std::set<int> visited;
  std::stack<std::pair<int, LampSetState>> nodeIds;
  nodeIds.push(std::make_pair(startNodeId, learnedState));
  int onCount = 0;
  while (!nodeIds.empty()) {
    std::pair<int, LampSetState> currentNode = nodeIds.top();
    nodeIds.pop();
    if (visited.find(currentNode.first) != visited.end()) continue;
    nodes[currentNode.first].state = currentNode.second;
    onCount += ((currentNode.second == LampSetState::On ||
                 currentNode.second == LampSetState::PhantomA)
                    ? 1
                    : 0);
    visited.insert(currentNode.first);
    for (const Edge &e : graph[currentNode.first]) {
      if (visited.find(e.nodeId) == visited.end())
        nodeIds.push(
            std::make_pair(e.nodeId, deducedState(e.cons, currentNode.second)));
    }
  }
  int ownerId = nodes[startNodeId].ownerId;
  nodes[ownerId].onColorSize = onCount;
  nodes[ownerId].offColorSize = nodes[ownerId].componentSize - onCount;
}
void switchOwner(std::vector<Edges> &graph, std::vector<LampSetInfo> &nodes,
                 int startNodeId, int newOwner) {
  std::set<int> visited;
  std::stack<int> nodeIds;
  nodeIds.push(startNodeId);
  while (!nodeIds.empty()) {
    int currentNode = nodeIds.top();
    nodeIds.pop();
    if (visited.find(currentNode) != visited.end()) continue;
    visited.insert(currentNode);
    nodes[currentNode].ownerId = newOwner;
    for (auto &e : graph[currentNode]) {
      if (visited.find(e.nodeId) == visited.end()) nodeIds.push(e.nodeId);
    }
  }
}
int main() {
  int n, k;
  long long result = 0;
  std::string lamps;
  std::vector<LampSetInfo> nodes;
  std::cin >> n >> k;
  std::cin >> lamps;
  std::vector<std::vector<int>> setsForLamp(n);
  std::vector<Edges> graph(k, Edges(compareEdges));
  for (int i = 0; i < k; i++) {
    int c;
    nodes.push_back(LampSetInfo(i));
    std::cin >> c;
    for (int j = 0; j < c; j++) {
      int a;
      std::cin >> a;
      setsForLamp[a - 1].push_back(i);
    }
  }
  for (int i = 0; i < n; i++) {
    LampSetState learnedState;
    LampConstraint cons;
    int startNode;
    int a, b, ownerA, ownerB;
    switch (setsForLamp[i].size()) {
      case 0:
        if (lamps[i] != '1')
          throw std::runtime_error("Conflicting enforced states of lamps!");
        break;
      case 1:
        startNode = setsForLamp[i][0];
        learnedState = (lamps[i] == '1' ? LampSetState::Off : LampSetState::On);
        if (!isLampSetStateKnown(nodes[startNode].state)) {
          result -= componentOnBestSize(nodes, startNode);
          propagateLampState(graph, nodes, startNode, learnedState);
          result += componentOnBestSize(nodes, startNode);
        } else {
          if (learnedState != nodes[startNode].state)
            throw std::runtime_error("Conflicting enforced states of lamps!");
        }
        break;
      case 2:
        a = setsForLamp[i][0];
        b = setsForLamp[i][1];
        ownerA = nodes[a].ownerId;
        ownerB = nodes[b].ownerId;
        cons =
            (lamps[i] == '1' ? LampConstraint::Same : LampConstraint::Distinct);
        if (nodes[ownerA].componentSize > nodes[ownerB].componentSize) {
          std::swap(a, b);
          std::swap(ownerA, ownerB);
        }
        if (ownerA != ownerB) {
          result -= componentOnBestSize(nodes, ownerA);
          result -= componentOnBestSize(nodes, ownerB);
          if (isLampSetStateKnown(nodes[a].state) &&
              !isLampSetStateKnown(nodes[b].state)) {
            propagateLampState(graph, nodes, b,
                               deducedState(cons, nodes[a].state));
          } else if (isLampSetStateKnown(nodes[b].state) &&
                     !isLampSetStateKnown(nodes[a].state)) {
            propagateLampState(graph, nodes, a,
                               deducedState(cons, nodes[b].state));
          } else if (!isLampSetStateKnown(nodes[b].state) &&
                     !isLampSetStateKnown(nodes[a].state)) {
            propagateLampState(graph, nodes, a,
                               deducedState(cons, nodes[b].state));
          }
          nodes[ownerB].onColorSize += nodes[ownerA].onColorSize;
          nodes[ownerB].offColorSize += nodes[ownerA].offColorSize;
          nodes[ownerB].componentSize += nodes[ownerA].componentSize;
          result += componentOnBestSize(nodes, ownerB);
          switchOwner(graph, nodes, a, ownerB);
        }
        graph[a].insert(Edge(b, cons));
        graph[b].insert(Edge(a, cons));
        break;
      default:
        throw std::runtime_error("Malformed input data!");
    }
    std::cout << result << std::endl;
  }
  return 0;
}
