#include <cstdio>
#include <iostream>
#include <sstream>
#include <iomanip>
#include <algorithm>
#include <cmath>
#include <string>
#include <vector>
#include <list>
#include <queue>
#include <stack>
#include <set>
#include <map>
#include <bitset>
#include <numeric>
#include <climits>
#include <cfloat>
using namespace std;

const double EPS = 1.0e-10;
const double INF = DBL_MAX / 1000;

void linearSystem(vector<vector<double> >& mat, vector<double>& x)
{
    int n = mat.size();
    x.resize(n);

    for(int i=0; i<n; ++i){
        int tmp = i;
        for(int j=i; j<n; ++j){
            if(mat[j][i] > mat[tmp][i])
                tmp = j;
        }
        swap(mat[i], mat[tmp]);

        for(int j=n; j>=i; --j)
            mat[i][j] /= mat[i][i];
        for(int j=0; j<n; ++j){
            if(j == i)
                continue;
            for(int k=n; k>=i; --k){
                mat[j][k] -= mat[i][k] * mat[j][i];
            }
        }
    }

    for(int i=0; i<n; ++i)
        x[i] = mat[i][n];
}

class Edge{
public:
    int to, cap, rev;
    double cost;
    Edge(){};
    Edge(int to0, int cap0, double cost0){to = to0; cap = cap0, cost = cost0;}
    Edge(int to0, int cap0, double cost0, int rev0){to = to0; cap = cap0; cost = cost0; rev = rev0;}
};

double minCostFlow(const vector<vector<Edge> >& edges0, int source, int sink, int flow)
{
    int n = edges0.size();
    vector<vector<Edge> > edges(n);
    for(int i=0; i<n; ++i){
        for(unsigned j=0; j<edges0[i].size(); ++j){
            const Edge& e = edges0[i][j];
            edges[i].push_back(Edge(e.to, e.cap, e.cost, edges[e.to].size()));
            edges[e.to].push_back(Edge(i, 0, -e.cost, edges[i].size()-1));
        }
    }

    vector<double> h(n, 0.0);
    vector<int> prevV(n);
    vector<int> prevE(n);

    double ret = 0.0;
    while(flow > 0){
        vector<double> dist(n, INF);
        dist[source] = 0.0;
        priority_queue<pair<double,int> ,vector<pair<double,int> >, greater<pair<double,int> > > q;
        q.push(make_pair(0.0, source));

        while(!q.empty()){
            pair<double, int> p = q.top();
            q.pop();
            int v = p.second;
            if(dist[v] < p.first - EPS)
                continue;
            for(unsigned i=0; i<edges[v].size(); ++i){
                Edge e = edges[v][i];
                if(e.cap > 0 && dist[v] + e.cost + h[v] - h[e.to] < dist[e.to] - EPS){
                    dist[e.to] = dist[v] + e.cost + h[v] - h[e.to];
                    prevV[e.to] = v;
                    prevE[e.to] = i;
                    q.push(make_pair(dist[e.to], e.to));
                }
            }
        }
        if(dist[sink] > INF / 10)
            return -1.0;
        for(int i=0; i<n; ++i)
            h[i] += dist[i];

        int g = flow;
        for(int i=sink; i!=source; i=prevV[i])
            g = min(g, edges[prevV[i]][prevE[i]].cap);
        for(int i=sink; i!=source; i=prevV[i]){
            Edge& e = edges[prevV[i]][prevE[i]];
            e.cap -= g;
            edges[i][e.rev].cap += g;
        }
        flow -= g;
        ret += g * h[sink];
    }
    return ret;
}

int main()
{
    int T;
    cin >> T;

    while(--T >= 0){
        int n, s, t, f;
        cin >> n >> s >> t >> f;

        vector<vector<double> > a(n, vector<double>(n+1));
        for(int i=0; i<n; ++i){
            for(int j=0; j<n+1; ++j){
                cin >> a[i][j];
            }
        }
        vector<double> x; // 気温
        linearSystem(a, x);

        vector<vector<Edge> > edges(n);
        for(int i=0; i<n; ++i){
            int m;
            cin >> m;
            vector<int> to(m), cap(m);
            for(int j=0; j<m; ++j)
                cin >> to[j];
            for(int j=0; j<m; ++j)
                cin >> cap[j];

            for(int j=0; j<m; ++j)
                edges[i].push_back(Edge(to[j], cap[j], abs(x[i] - x[to[j]])));
        }

        double ret = minCostFlow(edges, s, t, f);
        if(ret < -0.5)
            cout << "impossible" << endl;
        else
            printf("%.10f\n", ret);
    }

    return 0;
}