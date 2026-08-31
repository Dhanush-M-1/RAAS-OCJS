#include <iostream>
#include <vector>
using namespace std;
int main(void)
{
	bool flag;
	int n,a,k=0,b;
	cin >> n;
	vector<int> v(n);
	for(int i=0;i<n;i++) cin >> v[i];
	for(int i=0;i<n;i++){
		b=i;
		flag=false;
		for(int j=i;j<n;j++){
			if(v[j]<v[b]){
				b=j;
				flag=true;
			}
		}
		if(flag==true) k+=1;
		a=v[i];
		v[i]=v[b];
		v[b]=a;
	}
	cout << v[0];
	for(int i=1;i<n;i++) cout << " " << v[i];
	cout << endl << k << endl;
	return 0;
}