#include <cstdio>
#include <vector>
using namespace std;

int main() {
	int n,min, s=0;
	vector<int> a;
	scanf("%d",&n);
	a.resize(n);
	for(int i=0; i<n; ++i) {
		scanf("%d",&a[i]);
	}
	for(int i=0; i<n; ++i) {
		min=i;
		for(int j=i+1; j<n; ++j) {
			if(a[j]<a[min]) {
				min=j;
			}
		}
		if(min!=i) {
			swap(a[i],a[min]);
			++s;
		}
	}
	for(int i=0; i<n-1; ++i) {
		printf("%d ",a[i]);
	}
	printf("%d\n%d\n",a[n-1],s);
	return 0;
}