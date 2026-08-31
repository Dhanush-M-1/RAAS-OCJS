#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <iostream>

using namespace std;

struct point {
	double x, y;
}p[5];

double dis(point A, point B) {
	return sqrt((A.x - B.x) * (A.x - B.x) + (A.y - B.y) * (A.y - B.y));
}

double crossProd(point A, point B, point C) {
	return (B.x - A.x) * (C.y - A.y) - (B.y - A.y) * (C.x - A.x);
}

int cmp(const void *a, const void *b) {
	point *c = (point *)a;
	point *d = (point *)b;
	double k = crossProd(p[0], *c, *d);
	if (k < 0 || !k && dis(p[0], *c) > dis(p[0], *d)) return 1;
	return -1;
}

bool solve() {
	double x = p[0].x;
	double y = p[0].y;
	int mi = 0;
	for (int i=1; i<4; ++i) {
		if (p[i].y < y || p[i].y == y && p[i].x < x) {
			x = p[i].x;
			y = p[i].y;
			mi = i;
		}
	}
	point tmp = p[0];
	p[0] = p[mi];
	p[mi] = tmp;
	qsort(p, 4, sizeof(point), cmp);
	if (crossProd(p[0], p[1], p[2]) > 0 &&
		crossProd(p[1], p[2], p[3]) > 0 &&
		crossProd(p[2], p[3], p[0]) > 0) return true;
	return false;
}

int main() {
	while (scanf("%lf,%lf", &p[0].x, &p[0].y) != EOF) {
		for (int i=1; i<4; ++i) scanf (",%lf,%lf", &p[i].x, &p[i].y);
		bool yes = solve();
		if (yes) printf ("YES\n");
		else printf ("NO\n");
	}
	return 0;
}