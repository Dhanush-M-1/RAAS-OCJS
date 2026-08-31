#include <bits/stdc++.h>
#include <algorithm>
using namespace std;
long long int gcd(long long int x, long long int y){
long long int r;
if(x < y) swap (x, y); 
while(y > 0){
r = x % y; 
x = y; 
y = r;
}
return x; 
}
int main() {
int T; 
long long int A, B, C, D; 
cin >> T; 
for (int i = 0; i < T; i++){
cin >> A >> B >> C >> D;
long long int E = A - (A - C + B - 1)/ B * B; 
if(A < B || E < 0) cout << "No" << endl; 
else if(C < B - gcd(B, D) || B > D) 
cout << "No" << endl; 
else cout << "Yes" << endl; 
}
}