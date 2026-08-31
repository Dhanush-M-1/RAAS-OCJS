#include<iostream>
#include<vector>
using namespace std;
 
int main(){
int n, m;
vector<long long> a, b, c, d;
cin >> n >> m;
a.resize(n);
b.resize(n);
c.resize(m);
d.resize(m);
for(int i=0; i < n; i++) cin >> a[i] >> b[i];
for(int i=0; i<m;i++) cin >> c[i] >> d[i];
for (int i=0;i<n;i++){
long long mi = 10000000000;
int id= 0;
for (int j=0; j < m; j++) if (abs(a[i] - c[j]) + abs(b[i] - d[j]) < mi){
mi = abs(a[i] - c[j]) + abs(b[i] - d[j]);
id = j;
}
cout << id+1<< endl;
}
return 0;
}