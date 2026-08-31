#include <bits/stdc++.h>
#define FOR(i,a,b) for(int i=(a);i<(b);i++)
#define RFOR(i,a,b) for(int i=(b) - 1;i>=(a);i--)
#define REP(i,n) for(int i=0;i<(n);i++)
#define RREP(i,n) for(int i=n-1;i>=0;i--)

#define PB push_back
#define INF INT_MAX/3
#define ALL(a) (a).begin(),(a).end()
#define CLR(a) memset(a,0,sizeof(a))

typedef long long int ll;

using namespace std;
int ans;

void bubblesort(vector<int>& a){
    REP(i,a.size()){
	for(int j=0;j<a.size()-1;j++){
	    if(a[j] > a[j+1]){
		swap(a[j],a[j+1]);
		ans++;
	    }
	}
    }
}

int main(){
    while(true){
	int n;
	vector<int> a;
	ans = 0;
	cin >> n;
	if(n == 0) break;
	REP(i,n){
	    int temp;
	    cin >> temp;
	    a.PB(temp);
	}
	bubblesort(a);
	cout << ans << endl;
    }
    return 0;
}