package catan.map;

public record Harbor(HarborType harborType, Resource resource) {

    public static Harbor threeToOne() {
        return new Harbor(HarborType.THREE_TO_ONE, null);
    }

    public static Harbor twoToOne(Resource resource) {
        return new Harbor(HarborType.TWO_TO_ONE, resource);
    }

}
