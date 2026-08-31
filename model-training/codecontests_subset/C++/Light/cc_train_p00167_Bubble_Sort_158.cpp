#include "bits/stdc++.h"
using namespace std;
typedef long long ll;
typedef pair<int,int> P;

static const double eps = 1e-8;
int n;
int cnt;
int main(){
	while(cin>>n&&n){
		int A[n];
		for (int i = 0; i < n; ++i) {
			cin>>A[i];
		}
		cnt=0;
		for (int i = n-1; i > 0; --i) {
			for (int j = 0; j < i; ++j) {
				if (A[j]>A[j+1]) {
					swap(A[j],A[j+1]);
					cnt++;
				}
			}
		}
		cout<<cnt<<endl;
	}
}