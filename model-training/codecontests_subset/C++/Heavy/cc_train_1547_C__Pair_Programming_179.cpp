/*
	Author : Arvinder Singh
*/

#include <bits/stdc++.h>
using namespace std;

#define FIO ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0);
void INPUT()
{ 
#ifndef ONLINE_JUDGE
  freopen("C:/Users/arvindersingh/Desktop/Current/input.txt", "r", stdin);
  freopen("C:/Users/arvindersingh/Desktop/Current/output.txt", "w", stdout);
#endif
}

#define ll long long
#define ar array
//#define PI 3.14159
const double PI=acos(-1);
const long long mod = 1e9+7;
#define vint vector<int>
#define vfloat vector<float>
#define pb push_back
#define fo(i,n) for(i=0;i<n;i++)
#define fok(i,k,n) for(i=k;i<n;i++)

int size=1000000;
//int a[size];

int k,n,m;

void solve() {
	cin>>k>>n>>m;

	vector<int> a(n),b(m);

	for (int i = 0; i < n; ++i)
	{
		cin>>a[i];
	}

	for (int i = 0; i < m; ++i)
	{
		cin>>b[i];
	}

	/////////// logic
	int itr1=0,itr2=0;
	vector<int> ans;

	while(itr1<n or itr2<m){
		if(itr1 < n and a[itr1] == 0){
			ans.push_back(a[itr1]);
			k++;
			itr1++;
		}
		else if(itr1 < n and a[itr1] <= k){
			ans.push_back(a[itr1]);
			itr1++;
		}else if(itr2 < m and b[itr2] == 0){
			ans.push_back(b[itr2]);
			k++;
			itr2++;
		}else if(itr2 < m and b[itr2] <= k){
			ans.push_back(b[itr2]);
			itr2++;
		}else{
			cout<<"-1"<<endl;
			return;
		}
	}

	for(int i:ans)
		cout<<i<<" ";

	cout<<endl;

}

int main(int argc, char const *argv[])
{
	FIO
	INPUT();

	ll t = 1;
	cin >> t;

	while (t--)
	{
		solve();

	}
	return 0;
}
